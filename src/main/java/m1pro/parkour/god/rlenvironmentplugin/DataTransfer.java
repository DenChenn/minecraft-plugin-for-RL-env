package m1pro.parkour.god.rlenvironmentplugin;

import io.grpc.Channel;
import io.grpc.StatusRuntimeException;
import io.grpc.data_transfer.DataTransferGrpc;
import io.grpc.data_transfer.LearningData;

import java.util.logging.Level;
import java.util.logging.Logger;


public class DataTransfer {
    private final DataTransferGrpc.DataTransferBlockingStub blockingStub;

    private static final Logger logger = Logger.getLogger(DataTransfer.class.getName());

    /** Construct client for accessing RouteGuide server using the existing channel. */
    public DataTransfer(Channel channel) {
        blockingStub = DataTransferGrpc.newBlockingStub(channel);
    }

    public static boolean isExists(LearningData.ModelResponse modelResponse) {
        return modelResponse != null && !modelResponse.getStatus().isEmpty();
    }

    private void info(String msg, Object... params) {
        logger.log(Level.INFO, msg, params);
    }

    private void warning(String msg, Object... params) {
        logger.log(Level.WARNING, msg, params);
    }

    public void sendDataToModel(int x, int y, int z, String player_state) {
        LearningData.Data request = LearningData.Data.newBuilder().setX(x).setY(y).setZ(z).setPlayerState(player_state).build();

        LearningData.ModelResponse modelResponse;
        try {
            modelResponse = blockingStub.sendDataToModel(request);
        } catch (StatusRuntimeException e) {
            warning("RPC failed: {0}", e.getStatus());
            return;
        }

        if (isExists(modelResponse)) {
            info("Found model response status {0}", modelResponse.getStatus());
        } else {
            info("Found no feature.");
        }
    }
}
