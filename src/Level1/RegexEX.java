package Level1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수
class RegexEX{
    public String solution(String phone_number) {
     String Regex = "\\d{4}$";
        String answer = phone_number;
        String temp = answer.substring(0,phone_number.length()-4);
        temp = temp.replaceAll("\\d","*");
        Pattern pattern = Pattern.compile(Regex);
        Matcher matcher = pattern.matcher(answer);
        if(matcher.find()){
            answer=temp;
            answer=answer.concat(matcher.group());
        }
        return answer;
    }
}