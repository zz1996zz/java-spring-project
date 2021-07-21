package com.example.restaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T>{

    private final List<T> db = new ArrayList<>(); // 데이터를 저장하는 db 역할을 한다.
    private int index = 0;

    @Override
    public Optional<T> findById(int index) { // db 에 있는 데이터의 index 와 입력해준 index 를 비교하여 찾아준다.
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
    }

    @Override
    public T save(T entity) { // db 에 있는 데이터의 index 와 입력해준 entity 의 index 를 비교하여 데이터가 db에 있는지 없는지 확인 후 작업한다.

        var optionalEntity = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();

        if(optionalEntity.isEmpty()){
            // db 에 데이터가 없는 경우
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;
        }else{
            // db 에 이미 데이터가 있는 경우
            // entity를 업데이트 해줘야 하기 때문에 기존에 있던 entity에서 index를 가져와서 새로운 entity에 저장해주고, 기존 entity는 삭제한다.
            var preIndex = optionalEntity.get().getIndex();
            entity.setIndex(preIndex);

            deleteById(preIndex);
            db.add(entity);
            return entity;
        }
    }

    @Override
    public void deleteById(int index) {

        var optionalEntity = db.stream().filter(it -> it.getIndex() == index).findFirst();

        if(optionalEntity.isPresent()){ // isPresent() : 저장된 값이 존재하면 true를 반환하고, 값이 존재하지 않으면 false를 반환함.
            db.remove(optionalEntity.get());
        }
    }

    @Override
    public List<T> findAll() {
        return db;
    }
}
