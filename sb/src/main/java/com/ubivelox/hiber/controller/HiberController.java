package com.ubivelox.hiber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ubivelox.hiber.model.service.HiberService;

@Controller
public class HiberController
{
    @Autowired
    private HiberService hiberService;

}
