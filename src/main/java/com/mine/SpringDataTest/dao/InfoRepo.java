package com.mine.SpringDataTest.dao;

import javax.sound.midi.MidiDevice.Info;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="info", path="info")
public interface InfoRepo extends JpaRepository<Info, Integer> {
}
