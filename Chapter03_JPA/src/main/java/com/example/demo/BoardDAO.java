package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface BoardDAO extends JpaRepository<BoardDTO, String>{
public interface BoardDAO extends JpaRepository<BoardDTO, Integer>{

}



/* 
  JpaRepository<BoardDTO, ID>
  JpaRepository<엔티티 클래스, primary key의 타입(자료형)을 쓴다.>{
 
 */


