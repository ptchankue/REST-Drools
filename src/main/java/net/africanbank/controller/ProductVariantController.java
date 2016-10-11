package net.africanbank.controller;

import net.africanbank.domain.ProductVariant;
import net.africanbank.service.ProductVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by patricktchankue on 5/13/16.
 */
@RestController
@RequestMapping(value = "/product/variant")
public class ProductVariantController {

    @Autowired
    private ProductVariantService productVariantService;

    @RequestMapping(value = "/")
    public List<ProductVariant> get() {

        return productVariantService.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ProductVariant search(@RequestParam("product") String product,
                                 @RequestParam("variant") String variant)
    {
        return productVariantService.findByProductAndVariant(product, variant);
    }

    @RequestMapping(value = "/rule", method = RequestMethod.POST)
    public ProductVariant get(@RequestBody ProductVariant application) {
        return productVariantService.findByProductAndVariant(application.getProduct(),
                application.getVariant());
    }
    @RequestMapping(value="/test", method=RequestMethod.POST)
    public ResponseEntity<ProductVariant>get2(@RequestBody ProductVariant product){
        ProductVariant p = productVariantService.findByProductAndVariant(product.getProduct(), product.getVariant());
        //return new ResponseEntity<ProductVariant>(p[0], HttpStatus.OK);
        return null;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity add(@Valid @RequestBody ProductVariant payload) {
        try {
            ProductVariant app = productVariantService.save(payload.getRuleName(),
                    payload.getProduct(),
                    payload.getVariant(),
                    payload.getResult());
            return new ResponseEntity<ProductVariant>(app, HttpStatus.CREATED);
        }catch (Exception ex){
            System.out.println(">>> Exception: "+ ex.toString());
            Map<String,String> result = new HashMap<String,String>();

            result.put("message", ex.toString());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(result);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody ProductVariant payload) {
        try {
            ProductVariant _payload = productVariantService.update(payload);
            return new ResponseEntity<ProductVariant>(_payload, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            Map<String,String> result = new HashMap<String,String>();

            result.put("message", ex.toString());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(result);
        }
    }

}
