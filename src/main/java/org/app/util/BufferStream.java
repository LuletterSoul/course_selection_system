package org.app.util;


import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


/**
 * @author ÁõÏéµÂ qq313700046@icloud.com .
 * @date Created in ${Time} ${Date}.
 * @decreption
 * @modified By: .
 */
public class BufferStream

{

    private final Scanner scanner;

    private final PrintStream out;

    public BufferStream(InputStream in, PrintStream printStream)
    {
        this.scanner = new Scanner(in);
        this.out = printStream;
    }

    public BufferStream()
    {
        scanner = new Scanner(System.in);
        out=System.out;
    }

    public void  Output(Object string)
    {

        out.println(string);
    }

    public int nextInt()
    {
        return scanner.nextInt();
    }

    public String nextString()
    {
        return scanner.nextLine();
    }

    public Float nextFloat()
    {
        return  scanner.nextFloat();
    }

}
