package com.techprimers.springbatchexample1.batch;

import com.techprimers.springbatchexample1.model.User;
import com.techprimers.springbatchexample1.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * 
 * @author dell
 *
 */
@Component
public class DBWriter implements ItemWriter<User> {

    @Autowired
    private UserRepository userRepository;
/**
 * 
 */
//    private Resource outputResource = new FileSystemResource("out/outputData.csv");
//    
//    @Bean
//    public FlatFileItemWriter<User> writer() {
//        //Create writer instance
//        FlatFileItemWriter<User> writer = new FlatFileItemWriter<>();
//         
//        //Set output file location
//        writer.setResource(outputResource);
//         
//        //All job repetitions should "append" to same output file
//        writer.setAppendAllowed(true);
//         
//        //Name field values sequence based on object properties
//        writer.setLineAggregator(new DelimitedLineAggregator<User>() {
//            {
//                setDelimiter(",");
//                setFieldExtractor(new BeanWrapperFieldExtractor<User>() {
//                    {
//                        setNames(new String[] { "id", "name", "dept" ,"salary","time","salaireBrute" });
//                    }
//                });
//            }
//        });
//        return writer;
//    }
    
    @Override
    public void write(List<? extends User> users) throws Exception {

        System.out.println("Data Saved for Users: " + users);
        userRepository.save(users);
        
        
    }
}
