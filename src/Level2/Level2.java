package Level2;

import java.util.ArrayList;

public class Level2{
    public Level2(){
        System.out.println("Level2 Test");
    }
    public void MaxPrice(String expression){
        int max = -1;
        int count = 0;
        ArrayList<String[]> arrayList = new ArrayList<>();
        ArrayList<Character> data = new ArrayList<>();
        if(expression.contains("*")){
            count++;
        }
        if(expression.contains("+")){
            count++;
        }
        if(expression.contains("-")){
            count++;
        }
        String[] test = expression.split("\\D");
        String[] test1 = expression.split("\\d");
        System.out.println(test.length);
        

        for (char temp : expression.toCharArray()) {
            data.add(temp);            
        }
        //arrayList.add(new String[]{"*,-,+"});
        arrayList.add(new String[]{"*,+,-"});
        // arrayList.add(new String[]{"+,-,*"});
        // arrayList.add(new String[]{"+,*,+"});
        // arrayList.add(new String[]{"-,*,+"});
        // arrayList.add(new String[]{"-,+,*"});
        for(int i = 0 ; i < arrayList.size();i++ ){
            int result = Math.abs(sum_MaxPrice(data,arrayList.get(i)));
            if(max<result) {
                max = result;   
            }
        }
       
        
        System.out.println("result: "+max);
    }

    private int sum_MaxPrice(ArrayList<Character> data, String[] strings){
        int size = strings.length;
        for(int i = 0 ; i< size;i++){
            String ex = strings[i];
            System.out.println(ex+" "+data.contains(ex.charAt(0)));
            while(data.contains(ex.charAt(0))){
                if(data.size()<2) break;
                int index = data.indexOf(ex.charAt(0));
                int first = Integer.valueOf(data.get(index-1).toString());
                int second = Integer.valueOf(data.get(index+1).toString());
                System.out.println(index +" "+ first+" "+ second);
                data.remove(index-1);
                data.remove(index-1);
                data.remove(index-1);
                switch(ex){
                    case "*":
                        System.out.println((first * second));
                        data.add(index-1, String.valueOf(first * second).charAt(0));
                        System.out.println(data.get(0));
                        System.out.println(data.get(index-1));
                        break;
                    case "-":
                        System.out.println(first - second);
                        data.add(index-1, String.valueOf(first - second).charAt(0));
                        break;
                    case "+":
                    data.add(index-1, String.valueOf(first + second).charAt(0));
                        break;
                }
            }

        }
    
        return String.valueOf(data.get(0)).charAt(0);
    }
   
}