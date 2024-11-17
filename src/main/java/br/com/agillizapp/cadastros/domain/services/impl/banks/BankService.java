package br.com.agillizapp.cadastros.domain.services.impl.banks;

import br.com.agillizapp.cadastros.api.config.handler.exception.ApiException;
import br.com.agillizapp.cadastros.api.config.handler.util.ExceptionCodeEnum;
import br.com.agillizapp.cadastros.api.request.banks.BankRequest;
import br.com.agillizapp.cadastros.domain.repositories.BankRepository;
import br.com.agillizapp.cadastros.domain.repositories.entities.BankEntity;
import br.com.agillizapp.cadastros.domain.services.banks.IBankService;
import br.com.agillizapp.cadastros.domain.services.dtos.banks.BankDTO;
import br.com.agillizapp.cadastros.domain.services.dtos.PageDTO;
import br.com.agillizapp.cadastros.domain.services.filter.BankFilter;
import br.com.agillizapp.cadastros.domain.services.mappers.banks.BankMapper;
import br.com.agillizapp.cadastros.domain.services.mappers.banks.BankRequestMapper;
import br.com.agillizapp.cadastros.domain.services.validators.BankValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BankService implements IBankService {

    private final BankRepository repository;
    private final BankValidator validator;

    private final BankRequestMapper requestMapper;
    private final BankMapper mapper;

    @Override
    public BankDTO saveBank(BankRequest request) {
        validator.existsCodeBank(
                repository.findBankByCode(request.getCode()).isPresent());

        var bankSave = repository.save(requestMapper.toEntity(request));

        return mapper.toDto(bankSave);
    }

    @Override
    public PageDTO<BankDTO> findByBankFilter(BankFilter bankFilter, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));

        Page<BankEntity> banks = repository.findByBankFilter(bankFilter, pageable);

        PageDTO<BankDTO> pageDTO = new PageDTO<>(mapper.toDto(banks.getContent()));
        pageDTO.setFirst(banks.isFirst());
        pageDTO.setLast(banks.isLast());
        pageDTO.setNumber(banks.getNumber());
        pageDTO.setNumberOfElements(banks.getNumberOfElements());
        pageDTO.setSize(banks.getSize());
        pageDTO.setTotalElements(banks.getTotalElements());
        pageDTO.setTotalPages(banks.getTotalPages());

        return pageDTO;
    }

    @Override
    public BankDTO updateBank(Integer id, BankRequest request) {
        var bank = findBank(id);

        var bankSave = mapper.toEntity(bank);
        BeanUtils.copyProperties(request, bankSave, "id");
        bankSave.setId(id);
        repository.save(bankSave);

        return mapper.toDto(bankSave);
    }

    @Override
    public BankDTO findBank(Integer id) {
        var bank = repository.findById(id)
                .orElseThrow(() -> new ApiException(ExceptionCodeEnum.ERROR_ID_BANK_NOT_FOUND));

        return mapper.toDto(bank);
    }

    @Override
    public void removeBank(Integer id) {
        var bank = findBank(id);
        repository.delete(mapper.toEntity(bank));
    }

    @Override
    @Transactional
    public BankDTO partialBankUpdate(Integer id, Map<String, Object> fields) {
        var bank = mapper.toEntity(findBank(id));

        ObjectMapper objectMapper = new ObjectMapper();
        var bankOrigin = objectMapper.convertValue(fields, BankEntity.class);


        fields.forEach((nameProperty, value) -> {
            Field field = ReflectionUtils.findField(BankEntity.class, nameProperty);
            Objects.requireNonNull(field).setAccessible(true);

            Object newValue = ReflectionUtils.getField(field, bankOrigin);

            ReflectionUtils.setField(field, bank, newValue);
        });

        var bankUpdate = repository.save(bank);

        return mapper.toDto(bankUpdate);
    }
}
