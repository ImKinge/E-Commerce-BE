package com.ecommerce.ImageUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class ImageUtils {


    public static String decompressImage(byte[] data) throws DataFormatException, IOException, DataFormatException {
        String encoded = new String(Base64.getEncoder().encode(data));
        return encoded;
    }
}
