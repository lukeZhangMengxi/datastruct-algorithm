package java_lang_interface.regex.parse_paragraph_into_str_arr;

interface Solution {
    String[] parseWordsIntoLowerCase(String paragraph);    
}

class MySolution implements Solution {

    @Override
    public String[] parseWordsIntoLowerCase(String paragraph) {
        return paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+");
    }

}
