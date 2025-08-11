package br.com.movieflix.service;

import br.com.movieflix.entity.Category;
import br.com.movieflix.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    // listar todos
    public List<Category> findAll(){
       return repository.findAll();
    }

    // salvar
    public Category saveCategory(Category category){
        return repository.save(category);
    }

    //procura por id

    public Optional<Category> gettByCategoryId (Long id){
        return repository.findById(id);
    }

    //deletar

    public void deletar(Long id){
        repository.deleteById(id);
    }


}
