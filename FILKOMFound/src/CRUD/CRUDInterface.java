package CRUD;

import java.io.File;
import java.util.List;

public interface CRUDInterface<E> {
    public int addData(E data);
    public int updateData(E data);
    public int delData(E data);
    public List<E> showData();
}
