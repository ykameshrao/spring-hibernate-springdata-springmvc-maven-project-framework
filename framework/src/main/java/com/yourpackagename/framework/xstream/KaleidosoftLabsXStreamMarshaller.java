package com.yourpackagename.framework.xstream;

import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.io.*;
import java.net.URL;

/**
 * Meant to remove the class attribute from the response
 *
 * @author: Y Kamesh Rao
 * @created: 4/29/12 11:51 AM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
public class KaleidosoftLabsXStreamMarshaller implements HierarchicalStreamDriver {

    @Override public HierarchicalStreamReader createReader(Reader reader) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override public HierarchicalStreamReader createReader(InputStream inputStream) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override public HierarchicalStreamReader createReader(URL url) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override public HierarchicalStreamReader createReader(File file) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override public HierarchicalStreamWriter createWriter(Writer writer) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
