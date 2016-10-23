package com.lab.model;

/**
 * Created by saurav on 23/10/16.
 */
class Generator
{
    private String prefix;
    private int offset, count;

    public Generator(String pre, int o)
    {
        prefix = pre.trim();
        offset = o;
        count = 0;
    }
    public String generate()
    {
        count += 1;
        return String.format("%1$s%2$s",
                             prefix,
                             (offset + count));
    }
}
