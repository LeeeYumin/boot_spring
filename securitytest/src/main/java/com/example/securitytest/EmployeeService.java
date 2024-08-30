package com.example.securitytest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeeService implements UserDetailsService {
	private final EmployeeRepository employeeRepository;
	private final PasswordEncoder passwordEncoder;

    public Employee create(String empname, String email, String password) {
        Employee user = new Employee();
        user.setEmpname(empname);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        this.employeeRepository.save(user);
        return user;
    }
    
    public Employee getUser(String empname) {
        Optional<Employee> siteUser = this.employeeRepository.findByusername(empname);
            return siteUser.get();
    }
    
    @Override
    public UserDetails loadUserByUsername(String empname) throws UsernameNotFoundException {
        Optional<Employee> _siteUser = this.employeeRepository.findByusername(empname);
        if (_siteUser.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
        }
        Employee employee = _siteUser.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("admin".equals(empname)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return new User(employee.getEmpname(), employee.getPassword(), authorities);
    }
}