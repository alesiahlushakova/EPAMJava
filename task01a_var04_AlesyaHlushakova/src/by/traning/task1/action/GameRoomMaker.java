package by.traning.task1.action;

import by.traning.task1.entity.GameRoom;
import by.traning.task1.exception.StorageException;
import by.traning.task1.store.ToyStorage;
/**
 * @author  AlesyaHlushakova
 * class makes game room with the help of toy storage.
 */
public class GameRoomMaker {
    /**
     * constructor for class
     * @param allocatedMoney money given for the game room
     * @return game room
     * @throws StorageException exception while working with toy storage
     */
    public GameRoom makeGameRoom(final int allocatedMoney) throws StorageException {
        ToyStorage storage = ToyStorage.getInstance();
        GameRoom gameRoom = new GameRoom();
        if (storage.countOfPrices() <= allocatedMoney) {
            for (int i = 0; i < allocatedMoney; i++) {
                gameRoom.addToy(storage.takeToy());
            }
            return gameRoom;
        } else {
            throw new StorageException("Storage do not have enough money");
        }
    }
}
