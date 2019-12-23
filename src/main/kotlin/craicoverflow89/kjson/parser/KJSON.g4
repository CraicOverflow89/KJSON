grammar KJSON;

@header {
    import craicoverflow89.kjson.*;
    import java.lang.StringBuffer;
    import java.util.ArrayList;
    import java.util.HashMap;
}

// Parser Rules
json returns [KJSON result]
    :   jsonData {$result = new KJSON($jsonData.result);}
        EOF
    ;

jsonArray returns [KJSONArray result]
    :   {ArrayList<KJSONData> data = new ArrayList();}
        SQBR1
        (
            data1 = jsonData {data.add($data1.result);}
            (
                COMMA
                data2 = jsonData {data.add($data2.result);}
            )*
        )?
        SQBR2
        {$result = new KJSONArray(data);}
    ;

jsonChars
    :   CHAR+
    ;

jsonData returns [KJSONData result]
    :   (
            jsonArray {$result = $jsonArray.result;}
        |
            jsonDouble {$result = $jsonDouble.result;}
        |
            jsonInteger {$result = $jsonInteger.result;}
        |
            jsonMap {$result = $jsonMap.result;}
        |
            jsonString {$result = $jsonString.result;}
        )
    ;

jsonDigits
    :   DIGIT+
    ;

jsonDouble returns [KJSONDouble result]
    :   {
            StringBuffer buffer = new StringBuffer();
            boolean minus = false;
        }
        (
            MINUS {minus = true;}
        )?
        digit1 = jsonDigits {buffer.append($digit1.text);}
        (
            PERIOD {buffer.append(".");}
            digit2 = jsonDigits {buffer.append($digit2.text);}
        )?
        {
            double value = Double.parseDouble(buffer.toString());
            if(minus) value = -value;
            $result = new KJSONDouble(value);
        }
    ;

jsonInteger returns [KJSONInteger result]
    :   {boolean minus = false;}
        (
            MINUS {minus = true;}
        )?
        jsonDigits
        {
            int value = Integer.parseInt($jsonDigits.text);
            if(minus) value = -value;
            $result = new KJSONInteger(value);
        }
    ;

jsonMap returns [KJSONMap result]
    :   {ArrayList<KJSONMapPair> data = new ArrayList();}
        CUBR1
        (
            pair1 = jsonMapPair {data.add($pair1.result);}
            (
                COMMA
                pair2 = jsonMapPair {data.add($pair2.result);}
            )*
        )?
        CUBR2
        {$result = new KJSONMap(data);}
    ;

jsonMapPair returns [KJSONMapPair result]
    :   QUOTE jsonChars QUOTE COLON jsonData
        {$result = new KJSONMapPair($jsonChars.text, $jsonData.result);}
    ;

jsonString returns [KJSONString result]
    :   {StringBuffer buffer = new StringBuffer();}
        QUOTE
        (
            jsonChars {buffer.append($jsonChars.text);}
        |
            SPACE {buffer.append(" ");}
        )+
        QUOTE
        {$result = new KJSONString(buffer.toString());}
    ;

// Lexer Rules
COLON: ':';
COMMA: ',';
CUBR1: '{';
CUBR2: '}';
MINUS: '-';
PERIOD: '.';
QUOTE: '"';
SPACE: ' ';
SQBR1: '[';
SQBR2: ']';
WHITESPACE: [ \t\r\n]+ -> skip;
CHAR: .;