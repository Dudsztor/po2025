import java.util.ArrayList;

public class CodingBat {
    public boolean sleepIn(boolean weekday, boolean vacation) {
        if(!weekday || vacation)
            return true;
        else
            return false;
    }

    public boolean sum28(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if (nums[i] == 2)
                sum +=2;
        }
        if(sum==8)
            return true;
        else
            return false;
    }

    public String frontBack(String str) {
        if (str.length()<=1)
            return str;
        String mid = str.substring(1,str.length()-1);
        return str.charAt(str.length()-1)+mid+str.charAt(0);
    }

    public String helloName(String name) {
        return ("Hello " + name + "!");
    }

}
