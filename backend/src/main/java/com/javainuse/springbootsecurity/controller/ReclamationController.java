package com.javainuse.springbootsecurity.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javainuse.springbootsecurity.dao.enitity.Reclamation;
import com.javainuse.springbootsecurity.dao.enitity.User;
import com.javainuse.springbootsecurity.services.IReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/reclamation")
public class ReclamationController {
    @Autowired
    ServletContext context;
    @Autowired
    private IReclamationService iReclamationService;


    @GetMapping("/")
    public List<Reclamation> getProduits(){
        return  iReclamationService.getAllReclamation();

    }
    @GetMapping("/find")
    public Reclamation getProduit(@RequestParam Long id){
        return  iReclamationService.findById(id).orElse(null);

    }

    @PostMapping("/add")
    public Reclamation addProduit(@RequestParam("file[]") MultipartFile file[],
                              @RequestParam("reclamation") String reclamation)
            throws JsonParseException, JsonMappingException, Exception
    {
        Reclamation prod = new ObjectMapper().readValue(reclamation, Reclamation.class);
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        System.out.println("mk filéé............."+file );
        if (!isExit)
        {
            new File (context.getRealPath("/Images/")).mkdir();
            System.out.println("mk dir.............");
        }
        for (MultipartFile fil:file
        ) {
            String filename = fil.getOriginalFilename();
            Double x =Math.random()*5000;
            String newFileName = FilenameUtils.getBaseName(filename)+x.toString()+"."+FilenameUtils.getExtension(filename);
            File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
            try
            {

                FileUtils.writeByteArrayToFile(serverFile,fil.getBytes());

            }catch(Exception e) {
                e.printStackTrace();
            }

            prod.setAttachement(newFileName);
            iReclamationService.addReclamation(prod);

        }






        return  prod;

    }
    @DeleteMapping("/remove")
    public boolean deleteProduit(@RequestParam Long id){
        return  iReclamationService.deleteReclamation(id);

    }
    @PutMapping ("/update")
    public boolean updateProduit(@RequestBody Reclamation reclamation){
        return  iReclamationService.updateReclamation(reclamation);

    }
    @GetMapping ("/findByUser")
    public List<Reclamation> findbyUser(@RequestParam User user){

        return  iReclamationService.findbyUser(user);

    }


}

