class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int count1 = 0;
        int count2 = 0;
        while(count1 < word.length() && count2 < abbr.length()) {
            char char1 = word.charAt(count1);
            char char2 = abbr.charAt(count2);
            if(Character.isLetter(char2)) {
                if(char1 == char2) {
                    count1++;
                    count2++;
                    continue;
                } else {
                    return false;
                }
            } else if(Character.isDigit(char2)) {
                if(char2 == '0') {
                    return false;
                }
                int count = 0;
                while(count2 < abbr.length() && Character.isDigit(abbr.charAt(count2))) {
                    count = count * 10 + (abbr.charAt(count2) - '0');
                    count2++;
                }

                count1 += count;
            }
        }

        return count1 == word.length() && count2 == abbr.length();
    }
}
