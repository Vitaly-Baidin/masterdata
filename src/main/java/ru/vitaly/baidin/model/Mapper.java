package ru.vitaly.baidin.model;

public interface Mapper<ModelDto, Model> {
    ModelDto mapToDto(Model model);
    Model mapToModel(ModelDto modelDto);
}
