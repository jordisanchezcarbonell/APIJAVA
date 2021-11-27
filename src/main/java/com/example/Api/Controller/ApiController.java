package com.example.Api.Controller;

import java.util.List;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.DeleteMapping;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.PutMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

        import  com.example.Api.BDClass.Frases;

import com.example.Api.FrasesSerbice.FraseService;
//Indiciamos que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/

public class ApiController {

    //Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private FraseService fraseService;

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/frase*/
    @GetMapping("/frase")
    public List<Frases> findAll(){
        //retornará todos los usuarios
        return fraseService.findAll();
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/api/frase/1*/
    @GetMapping("/frase/{fraseId}")
    public Frases getUser(@PathVariable int fraseId){
        Frases frase = fraseService.findById(fraseId);

        if(frase == null) {
            throw new RuntimeException("Frase id not found -"+fraseId);
        }
        //retornará al usuario con id pasado en la url
        return frase;
    }

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/frase/  */
    @PostMapping("/frase")
    public Frases addUser(@RequestBody Frases frase) {
        frase.setId(0);

        //Este metodo guardará al usuario enviado
        fraseService.save(frase);

        return frase;

    }
    /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/frase/  */
    @PutMapping("/frase")
    public Frases updateUser(@RequestBody Frases frase) {

        fraseService.save(frase);

        //este metodo actualizará al usuario enviado

        return frase;
    }

    /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
    http://127.0.0.1:8080/api/users/1  */
    @DeleteMapping("/frase/{fraseId}")
    public String deteteUser(@PathVariable int fraseId) {

        Frases user = fraseService.findById(fraseId);

        if(user == null) {
            throw new RuntimeException("Frase id not found -"+fraseId);
        }

        fraseService.deleteById(fraseId);

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        return "Deleted frase  id - "+fraseId;
    }

}