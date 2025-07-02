package one.innovation.digital.gof.service.impl;

import one.innovation.digital.gof.exceptions.IdAusenteException;
import one.innovation.digital.gof.model.Cliente;
import one.innovation.digital.gof.model.ClienteRepository;
import one.innovation.digital.gof.model.Endereco;
import one.innovation.digital.gof.model.EnderecoRepository;
import one.innovation.digital.gof.service.ClienteService;
import one.innovation.digital.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new IdAusenteException());
    }

    @Override
    public void inserir(Cliente cliente) {
        this.salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clientePorId = clienteRepository.findById(id);
        if(clientePorId.isPresent()) {
            cliente.setId(id);
            this.salvarClienteComCep(cliente);
        }else{
            throw new IdAusenteException();
        }
    }

    @Override
    public void deletar(Long id) {
        if(clienteRepository.findById(id).isEmpty()) {
            throw new IdAusenteException();
        }
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
