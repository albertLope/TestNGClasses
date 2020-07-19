package Day6._02_DataProvider;

import Day5._02_SearchFunctionality;
import Utils.BaseDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _04_SearchFunctionality extends BaseDriver {

    _02_SearchFunctionality searchFunc1 = new _02_SearchFunctionality();

    @Test(dataProvider ="itemName")
    public void SearchFunction2(String itemName ){
        searchFunc1.searchFunc(driver , itemName);
    }

    @DataProvider(name = "itemName")
    public Iterator<Object> createData1() {

        List<Object> list = new ArrayList<>();
        list.add("Phone");
        list.add("Mac");
        return list.iterator();

    }

}
