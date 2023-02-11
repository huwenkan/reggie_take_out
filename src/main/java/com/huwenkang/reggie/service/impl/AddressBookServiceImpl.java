package com.huwenkang.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huwenkang.reggie.entity.AddressBook;
import com.huwenkang.reggie.mapper.AddressBookMapper;
import com.huwenkang.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
