package by.traning.task1.action;

import by.traning.task1.entity.GameRoom;
import by.traning.task1.entity.Toy;
import by.traning.task1.exception.StorageException;
import by.traning.task1.store.ToyStorage;

import java.util.LinkedList;

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
    public GameRoom makeGameRoom(int allocatedMoney) throws StorageException {
        ToyStorage storage = ToyStorage.getInstance();
        GameRoom gameRoom = new GameRoom();
        LinkedList<Toy> list = new LinkedList<>(storage.getToys());
            for (int i = 0; i < storage.getToys().size();  i++) {
                if (list.get(i).getPrice() < allocatedMoney) {
                    gameRoom.addToy(storage.takeToy());
                    allocatedMoney -=list.get(i).getPrice();
                } else {
                    throw new StorageException("Storage does not have enough money");
                }
            }
            return gameRoom;

    }
}
