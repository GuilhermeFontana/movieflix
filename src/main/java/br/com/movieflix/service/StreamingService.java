package br.com.movieflix.service;

import br.com.movieflix.entity.Streaming;
import br.com.movieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {


    private final StreamingRepository repository;

    public StreamingService(StreamingRepository repository) {
        this.repository = repository;
    }

    // listar todos
   public List<Streaming> findAll(){
       return repository.findAll();
   }

    // salvar
    public Streaming save(Streaming streaming){
        return repository.save(streaming);
    }

    //procura por id

    public Optional<Streaming> gettByCategoryId (Long id){
        return repository.findById(id);
    }

    //deletar

    public void deletar(Long id){
        repository.deleteById(id);
    }


}
