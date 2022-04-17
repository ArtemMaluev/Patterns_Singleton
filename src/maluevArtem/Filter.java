package maluevArtem;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    private final int valueFilter;

    public Filter(int valueFilter) {
        this.valueFilter = valueFilter;
    }

    public List<Integer> filterOut(List<Integer> list) {
        List<Integer> listFilter = new ArrayList<>();
        Logger logger = Logger.getLog();
        logger.log("Запускаем фильтрацию");
        for (int i : list) {
            if (valueFilter > i) {
                listFilter.add(i);
                logger.log("Элемент " + i + " проходит фильтрацию");
            } else logger.log("Элемент " + i + " не проходит фильтрацию");
        }
        return listFilter;
    }
}
