package com.dl.pwbc.breedingCalculator.service;

public class Converter {

    public String reverseString(String palId){
        char[] ch = new char[palId.length()];
        int count = 0;
        for(int i = palId.length()-1; i >= 0; i--){
            ch[count] = palId.charAt(i);
            count++;
        }
        return new String(ch);
    }

    public String reverseString(StringBuffer palId){
        char[] ch = new char[palId.length()];
        int count = 0;
        for(int i = palId.length()-1; i >= 0; i--){
            ch[count] = palId.charAt(i);
            count++;
        }
        return new String(ch);
    }

    public int hexToDecimal(String palId){
        if(palId == null){
            return 0;
        } else {
            String revPalId = new String(reverseString(palId));
            int n = 0, value=1;
            for (int i = 0; i < palId.length(); i++) {
                switch(revPalId.toLowerCase().charAt(i)){
                    case 'a': value =10;
                        break;
                    case 'b': value = 11;
                        break;
                    case 'c': value = 12;
                        break;
                    case 'd': value = 13;
                        break;
                    case 'e': value = 14;
                        break;
                    case 'f': value = 15;
                        break;
                    default: value = revPalId.charAt(i) - '0';
                        break;
                }
                n = n + ((int) Math.pow(16,i) * value);
            }
            return n;
        }
    }

    public String decimalToHex(int palId){
        int n = palId;
        StringBuffer sb = new StringBuffer();
        int r;
        int count = 0;
        while(n!=0){
            r = n - ((n/16)*16);
            switch(r){
                case 10: sb.append('A');
                    break;
                case 11: sb.append('B');
                    break;
                case 12: sb.append('C');
                    break;
                case 13: sb.append('D');
                    break;
                case 14: sb.append('E');
                    break;
                case 15: sb.append('F');
                    break;
                default: sb.append(r);
                    break;
            }
            count++;
            n = n / 16;
        }

        return reverseString(sb);
    }

}
