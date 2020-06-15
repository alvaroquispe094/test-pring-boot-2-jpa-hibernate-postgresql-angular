package com.groupal.backendexamen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupal.backendexamen.dto.CompraComercioDto;
import com.groupal.backendexamen.service.CompraComercioService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class CompraComercioController {
	
	@Autowired
	private CompraComercioService compraComercioService;
	
	@GetMapping("/compraComercios")
    public ResponseEntity < List<CompraComercioDto> > getAllCompraComercios() {
        return ResponseEntity.ok().body(compraComercioService.findAll());
    }
    
    @GetMapping("/compraComercio/{id}")
    public ResponseEntity < CompraComercioDto > getCompraComercioById(@PathVariable Integer id) {
    	return ResponseEntity.ok().body(compraComercioService.findById(id));
    }
    
    @PostMapping("/compraComercio/guardar")
    public ResponseEntity < CompraComercioDto > guardarCompraComercio(@RequestBody CompraComercioDto compraComercioDto) {
        return ResponseEntity.ok().body(compraComercioService.save(compraComercioDto));
    }

//    @GetMapping("/books")
//    public ResponseEntity < List<Book> > getAllBooks() {
//        return ResponseEntity.ok().body(bookService.getAllBooks());
//    }
//
//    @GetMapping("/book/{id}")
//    public ResponseEntity < Book > getBookById(@PathVariable Integer id) {
//        return ResponseEntity.ok().body(bookService.getBookById(id));
//    }
//
//    @PostMapping("/book/add")
//    public ResponseEntity < Book > createBook(@RequestBody Book book) {
//        return ResponseEntity.ok().body(this.bookService.createBook(book));
//    }
//
//    @PutMapping("/book/update/{id}")
//    public ResponseEntity < Book > updateBook(@PathVariable Integer id, @RequestBody Book Producto) {
//        Producto.setId(id);
//        return ResponseEntity.ok().body(this.bookService.updateBook(Producto));
//    }
//
//    @DeleteMapping("/book/delete/{id}")
//    public HttpStatus deleteBook(@PathVariable Integer id) {
//        this.bookService.deleteBook(id);
//        return HttpStatus.OK;
//    }
//    

}
