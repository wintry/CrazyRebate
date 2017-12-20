package com.xuyh.CrazyRebate.service;

import javax.servlet.ServletContext;
import java.util.Map;

public interface ImageService {
    public Map uploadImage(String imgStr, ServletContext servletContext);
}
