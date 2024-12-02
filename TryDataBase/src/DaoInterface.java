import java.util.List;

public interface DaoInterface<E> {
    public  int addData(E data);
    public  int delData(E data);
    public  int updateData(E data);
    public int showGambar();
    public List<E> showData();

}
