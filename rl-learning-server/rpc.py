import learning_data_pb2
import learning_data_pb2_grpc
import grpc
from concurrent import futures
import logging
import pymongo
from datetime import datetime
from secret import *

cluster = pymongo.MongoClient(CONNECT_STRING)
db = cluster["minecraft"]
collection = db["state"]

class DataTransferServicer(learning_data_pb2_grpc.DataTransferServicer):
    def SendDataToModel(self, data, context):
        print("-----------------")
        print("Position X: " + str(data.x))
        print("Position Y: " + str(data.y))
        print("Position Z: " + str(data.z))
        print("Player state: " + str(data.player_state))
        print("-----------------")

        collection.insert_one({"x": data.x, "y": data.y, "z": data.z, "player_state": data.player_state,
                               "create_at": datetime.now()})
        return learning_data_pb2.ModelResponse(status="SUCCESS")


def serve():
    # initialize server with 4 workers
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=4))

    # attach servicer method to the server
    learning_data_pb2_grpc.add_DataTransferServicer_to_server(DataTransferServicer(), server)

    # start the server on the port 50051
    server.add_insecure_port("localhost:50051")
    server.start()
    print("Started gRPC server: localhost:50051")

    # server loop to keep the process running
    server.wait_for_termination()


# invoke the server method
if __name__ == "__main__":
    logging.basicConfig()
    serve()
