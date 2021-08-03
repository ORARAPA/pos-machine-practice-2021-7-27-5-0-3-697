package pos.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static pos.machine.ItemDataLoader.loadAllItemInfos;

public class PosMachine {
    List<ItemInfo> itemInfos = loadAllItemInfos();
    public String printReceipt(List<String> barcodes) {
        return null;
    }

    public List<String> getValuesFromBarcode(List<String> barcodes) {
        List<String> itemList = new ArrayList<>();

        //get name of what is in the cart using the barcodes
        for(int i=0; i<barcodes.size();i++){
            for(ItemInfo item: itemInfos) {
                if (item.getBarcode().equals(barcodes.get(i))) { //compare the barcode in ItemInfo and what is in the cart
                    itemList.add(item.getName()); //add the name of the item in the list
                }
            }
        }

        return itemList;
    }

    public static int countQuantity(List<String> itemList, String currentItem) {
        int count = 0;

        for(String item: itemList){
            if(item.equals(currentItem)){
                count++;
            }
        }

        return count;
    }


    public int calculate(List<String> itemList) {
        int totalPrice = calculateTotal(itemList);
        return totalPrice;
    }


    public String renderReceipt(List<String> itemList, int totalPrice) {
        return null;
    }


    public int calculateSubtotal(List<String> itemList, String currentItem) {
        int getQuantityofItem =0;
        int getPriceofItem =0;
        int subtotal = 0;

        for (ItemInfo item : itemInfos) {
            if (item.getName().equals(currentItem)){
                getPriceofItem = item.getPrice();
            }
        }

        subtotal = getQuantityofItem * getPriceofItem

        return subtotal;
    }


    public int calculateTotal(List<String> itemList) {
        List<String> distinctItems = itemList.stream().distinct().collect(Collectors.toList()); //get distinct items in list
        int totalPrice = 0;

        for(int i=0; i<distinctItems.size();i++){
            totalPrice = totalPrice + calculateSubtotal(itemList, distinctItems.get(i));
        }

        return totalPrice;
    }


}
