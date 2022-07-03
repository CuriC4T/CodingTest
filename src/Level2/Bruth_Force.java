package Level2;
class Bruth_Force{
    public int[] carpet(int brown, int yellow) {
        int[] answer = new int[2];
         if(yellow==1){
            answer[0] = 3;
            answer[1] = 3;
        }else{
             for(int i = 1 ;i <= yellow/2;i++){
            int a = yellow/i;
            if((a*i)==yellow){
                if(((a+2)*(i+2))==(brown+yellow)){
                    answer[0] = Math.max(a+2,i+2);
                    answer[1] = Math.min(a+2,i+2);
                    break;
                }
            }

        }
         }
        
        return answer;
    }
}