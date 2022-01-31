package ru.vitaly.baidin.mapper;

public interface Mapper<ModelDto, Model> {
    ModelDto mapToDto(Model model);
    Model mapToModel(ModelDto modelDto);
}
