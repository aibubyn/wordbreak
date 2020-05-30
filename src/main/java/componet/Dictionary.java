package componet;

import java.util.*;

public class Dictionary {


    //匹配单词的集合
    private static List<String> strArr = new ArrayList<>(Arrays.asList(new String[]{ "i", "like", "sam", "sung", "samsung", "mobile","ice", "cream", "man go", }));
    private static final String BLANK=" ";
    private final static String HAVEMATCHING = "@@haveMatching:";
    //匹配结果集合
    private static Set<String> set = Collections.synchronizedSet(new HashSet<>());

    public Dictionary() {
    }

    public Dictionary(String []str) {
        this.strArr=new ArrayList<>(Arrays.asList(str));
    }
    public Dictionary(String []str,String code) {
        strArr.addAll(new ArrayList<>(Arrays.asList(str)));
        this.strArr=strArr;
    }


    public Set<String> SearchNewSet(String str){
        Collections.sort(strArr, new SortByLengthComparator());
        for (String item : strArr) {
            int i = str.indexOf(item);
            if(i != -1){
                str = str.substring(0, i) + BLANK + str.substring(i, i+item.length()) + BLANK +str.substring(i+item.length(), str.length());
            }
        };
        set.add(this.removeMultipleSpaces(str.trim()));
        return set;
    }


    public Set<String> defaultRecursiveMatch(Set<String> set) {
        Set<String> temporarySet = Collections.synchronizedSet(new HashSet<>());
        for (String item : set) {
            String finalItem = item;
            if (item.indexOf(HAVEMATCHING) == -1){
                String[] temporaryArr = item.split(" ");
                for (int i = 0; i < temporaryArr.length; i++){
                    String currentStr = temporaryArr[i];
                    if(i != 0){
                        String lastStr = temporaryArr[i-1];
                        strArr.stream().filter(s -> s.equals(lastStr+currentStr)).findAny().ifPresent(s -> {
                            temporarySet.add(finalItem.replace(lastStr+BLANK+currentStr, lastStr+currentStr).trim());
                        });
                    }
                    if(i != temporaryArr.length-1){
                        String nextStr = temporaryArr[i+1];
                        strArr.stream().filter(s -> s.equals(currentStr+nextStr)).findAny().ifPresent(s -> {
                            temporarySet.add(finalItem.replace(currentStr+BLANK+nextStr, currentStr+nextStr).trim());
                        });
                    }
                }
                item = HAVEMATCHING+item;
            }
        }

        if(temporarySet.size() != 0){
            temporarySet.addAll(this.defaultRecursiveMatch(temporarySet));
        }
        temporarySet.addAll(set);
        return temporarySet;
    }
    public String removeMultipleSpaces(String str){
        return str.replaceAll(" +"," ");
    }


}
