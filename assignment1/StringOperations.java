package assignment1;


public class StringOperations {

    public static void main(String[] args) {

        // ===== STRING =====
        String str = "  Hello Java World  ";

        System.out.println("Length: " + str.length());
        System.out.println("Is Empty: " + str.isEmpty());
        System.out.println("Char At 2: " + str.charAt(2));
        System.out.println("Equals 'Hello': " + str.equals("Hello"));
        System.out.println("CompareTo 'Hello': " + str.compareTo("Hello"));
        System.out.println("Contains 'Java': " + str.contains("Java"));
        System.out.println("IndexOf 'o': " + str.indexOf('o'));
        System.out.println("LastIndexOf 'o': " + str.lastIndexOf('o'));
        System.out.println("StartsWith '  He': " + str.startsWith("  He"));
        System.out.println("EndsWith 'ld  ': " + str.endsWith("ld  "));
        System.out.println("Matches regex: " + str.matches(".*Java.*"));
        System.out.println("Substring: " + str.substring(2, 7));
        System.out.println("To LowerCase: " + str.toLowerCase());
        System.out.println("Trim: '" + str.trim() + "'");
        System.out.println("Replace: " + str.replace("Java", "Python"));

        String[] parts = str.trim().split(" ");
        System.out.println("Split:");
        for (String p : parts) {
            System.out.println(p);
        }

        String joined = String.join("-", parts);
        System.out.println("Join: " + joined);

        int num = 100;
        System.out.println("ValueOf: " + String.valueOf(num));

        // ===== STRINGBUFFER =====
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        sb.insert(5, " Java");
        sb.reverse();

        System.out.println("\nStringBuffer Result: " + sb.toString());

        // ===== STRINGBUILDER =====
        StringBuilder sb1 = new StringBuilder("Hello");
        sb1.append(" World");
        sb1.insert(5, " Java");
        sb1.delete(5, 10);

        System.out.println("StringBuilder Result: " + sb1.toString());
    }
}