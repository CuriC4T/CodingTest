package Level2;

import java.util.HashSet;

public class HashEx {
    // 길이 정렬 안되어있어서 순차로 startsWith 사용하면 안됨
    // + 이중 포문 비교는 효율성에서 걸림
    public boolean checkPrefix(String[] phone_book) {
        // 효율성 3,4번 걸림
        // if (phone_book.length == 1)
        // return false;
        // Arrays.sort(phone_book);
        // for (int i = 0; i < phone_book.length; i++) {
        // for (int j = i + 1; j < phone_book.length; j++) {
        // if (phone_book[j].startsWith(phone_book[i])) {
        // return false;
        // }
        // }
        // }

        // Arrays.sort(phone_book, new Comparator<String>(){};

        return true;
    }

    //for(int i=0; i<phoneBook.length-1; i++) {
    //     for(int j=i+1; j<phoneBook.length; j++) {
    //         if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
    //         if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
    //     }
    // }

    public boolean phoneBookPrefix(String[] phone_book){
        HashSet<String> hashSet = new HashSet<>();
        for (String num : phone_book) {
            hashSet.add(num);
        }
        for(int i = 0 ; i < phone_book.length ; i++){
            int size=phone_book[i].length();        
            for(int j = 1 ; j <size; j++ ){
                //123 이면 1,12가 있는지 확인
                if(hashSet.contains(phone_book[i].substring(0,j)))  return false;    
            }              
        }
        
        return true;
    }
}
