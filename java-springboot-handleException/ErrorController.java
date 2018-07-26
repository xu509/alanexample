package com.beautyofbook.api.control;

import com.beautyofbook.api.util.DateUtil;
import com.beautyofbook.api.util.Result;
import com.beautyofbook.api.util.ResultMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by xnx on 2018/7/4.
 */

@ControllerAdvice
@ResponseBody
public class ErrorController {

    @Value("${log_dir}")
    String log_dir;

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e, HttpServletRequest req) {

        String path = req.getRequestURL().toString();
        String exceptionName = e.toString();

        StackTraceElement stackTraceElement = e.getStackTrace()[0];
        String dateStr = DateUtil.format(new Date(),DateUtil.YEAR_MONTH_DAY_TIME);
        String filename = "exception" + DateUtil.format(new Date(),DateUtil.YEAR_MONTH_DAY) + ".txt";

        try {
            //此处写死了位置
            File logdir = new File(log_dir);

            if (!logdir.exists())
                logdir.mkdirs();

            File file = new File(logdir,filename);

            if (!file.exists())
                file.createNewFile();

            //写内容
            String line = "## [" + path + "] [" + dateStr + "] " + exceptionName;
            line += "\n(" + stackTraceElement.getClassName() + ") [" + stackTraceElement.getLineNumber() + "]" + " - " + stackTraceElement.getMethodName();

            FileWriter writer = new FileWriter(file,true);
            writer.write(line);
            writer.close();

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        return new Result(ResultMessage.INNER_ERROR);
    }



}
