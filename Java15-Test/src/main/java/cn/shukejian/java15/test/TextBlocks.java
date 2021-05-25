package cn.shukejian.java15.test;

public class TextBlocks {

    public static void main(String[] args) {
//        System.out.println(System.getenv());

        text_blocks();

        String singleLine = """
                Hello \
                World
                """;
        System.out.println(singleLine);

        String noIndentation = """
                First line
                Second line
                """;
        System.out.println(noIndentation);

        String indentedBySpaces = """
                    Frist line
                    Sencond line
                """;
        System.out.println(indentedBySpaces);

        var greeting = """
                hello
                %s
                """.formatted("world");
        System.out.println(greeting);

    }

    /**
     * Java 15 Text Blocks
     */
    public static void text_blocks(){
        String html = """
                <html>
                <body>
                    <p>Hello, world</p>
                </body>
                </html>
                """;

        System.out.println(html);

    }
}
