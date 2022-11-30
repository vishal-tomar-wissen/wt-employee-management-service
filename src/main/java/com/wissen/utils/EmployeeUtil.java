package com.wissen.utils;

import com.wissen.dto.*;
import com.wissen.entity.*;
import com.wissen.entity.key.EmployeeAccountId;
import com.wissen.entity.key.EmployeeSkillId;
import com.wissen.response.*;

import java.util.ArrayList;
import java.util.List;

public final class EmployeeUtil {

    public static Employee getEmployeeEntity(EmployeeDetailDTO employeeDetailDTO){
        Employee employee = new Employee();

        employee.setEmpId(employeeDetailDTO.getEmployeeId());
        employee.setFirstName(employeeDetailDTO.getFirstName());
        employee.setGender(employeeDetailDTO.getGender());
        employee.setDob(employeeDetailDTO.getDob());
        employee.setBloodGroup(employeeDetailDTO.getBloodGroup());
        employee.setPrimaryPhoneNumber(employeeDetailDTO.getPrimaryPhoneNumber());
        employee.setSecondaryPhoneNumber(employeeDetailDTO.getSecondaryPhoneNumber());
        employee.setLastName(employeeDetailDTO.getLastName());
        employee.setWorkPhone(employeeDetailDTO.getWorkPhone());
        employee.setPrimaryEmergencyContactNumber(employeeDetailDTO.getPrimaryEmergencyContactNumber());
        employee.setSecondaryEmergencyContactNumber(employeeDetailDTO.getSecondaryEmergencyContactNumber());
        employee.setMaritalStatusDate(employeeDetailDTO.getMaritalStatusDate());
        employee.setEmail(employeeDetailDTO.getEmail());
        employee.setDoj(employeeDetailDTO.getDoj());
        employee.setExpDoj(employeeDetailDTO.getExpDoj());
        employee.setExitDate(employeeDetailDTO.getExitDate());
        employee.setType(employeeDetailDTO.getType());
        employee.setJoiningLocation(employeeDetailDTO.getJoiningLocation());
        employee.setStatus(employeeDetailDTO.getStatus());
        employee.setManager(employeeDetailDTO.getManager());
        employee.setDesignation(getDesignationEntity(employeeDetailDTO.getDesignationDTO()));
        employee.setDepartment(getDepartmentEntity(employeeDetailDTO.getDepartmentDTO()));
        employee.setRole(getRoleEntity(employeeDetailDTO.getRoleDTO()));

        return employee;
    }

    public static Designation getDesignationEntity(DesignationDTO designationDTO){
        Designation designation = new Designation();
        designation.setDesgId(designationDTO.getDesgId());
        designation.setDesgName(designationDTO.getDesgName());
        return designation;
    }

    public static Department getDepartmentEntity(DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setDepId(departmentDTO.getDepId());
        department.setDepName(departmentDTO.getDepName());
        return department;
    }

    public static Role getRoleEntity(RoleDTO roleDTO){
        Role role = new Role();
        role.setRoleId(roleDTO.getRoleId());
        role.setRoleName(roleDTO.getRoleName());
        return role;
    }

    public static Address getAddressEntity(AddressDTO addressDTO, Employee employee){
        Address address = new Address();
        address.setAddrId(addressDTO.getAddressId());
        address.setEmployee(employee);
        address.setFlatNo(addressDTO.getFlatNo());
        address.setStreet(addressDTO.getStreet());
        address.setPincode(addressDTO.getPincode());
        address.setAddressType(addressDTO.getAddressType());
        address.setCity(addressDTO.getCity());
        address.setCountry(addressDTO.getCountry());
        address.setState(addressDTO.getState());

        return address;
    }

    public static EmployeeSkill getEmployeeSkillEntity(EmployeeSkillDTO employeeSkillDTO, Employee employee){
        EmployeeSkill employeeSkill = new EmployeeSkill();

        Skill skill = new Skill();
        skill.setSkillId(employeeSkillDTO.getSkillId());
        skill.setSkillName(employeeSkillDTO.getSkillName());

        employeeSkill.setEmployee(employee);
        employeeSkill.setSkill(skill);

        employeeSkill.setLevels(employeeSkillDTO.getLevels());

        return employeeSkill;
    }

    public static EmployeeAccount getEmployeeAccountEntity(EmployeeAccountDTO employeeAccountDTO, Employee employee){
        EmployeeAccount employeeAccount = new EmployeeAccount();
        EmployeeAccountId employeeAccountId = new EmployeeAccountId();

        employeeAccountId.setEmployee(employee);
        employeeAccount.setEmployeeAccountId(employeeAccountId);
        employeeAccount.setPan(employeeAccountDTO.getPan());
        employeeAccount.setPfNo(employeeAccountDTO.getPfNo());
        employeeAccount.setUan(employeeAccountDTO.getUan());

        return employeeAccount;
    }

    public static EmployeeResponse getEmployeeResponse(Employee employee){
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmpId(employee.getEmpId());
        employeeResponse.setFirstName(employee.getFirstName());
        employeeResponse.setGender(employee.getGender());
        employeeResponse.setDob(employee.getDob());
        employeeResponse.setBloodGroup(employee.getBloodGroup());
        employeeResponse.setPrimaryPhoneNumber(employee.getPrimaryPhoneNumber());
        employeeResponse.setSecondaryPhoneNumber(employee.getSecondaryPhoneNumber());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setWorkPhone(employee.getWorkPhone());
        employeeResponse.setPrimaryEmergencyContactNumber(employee.getPrimaryEmergencyContactNumber());
        employeeResponse.setSecondaryEmergencyContactNumber(employee.getSecondaryEmergencyContactNumber());
        employeeResponse.setMaritalStatusDate(employee.getMaritalStatusDate());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setDoj(employee.getDoj());
        employeeResponse.setExpDoj(employee.getExpDoj());
        employeeResponse.setExitDate(employee.getExitDate());
        employeeResponse.setType(employee.getType());
        employeeResponse.setJoiningLocation(employee.getJoiningLocation());
        employeeResponse.setStatus(employee.getStatus());
        employeeResponse.setManager(employee.getManager());
        employeeResponse.setDesignation(employee.getDesignation());
        employeeResponse.setDepartment(employee.getDepartment());
        employeeResponse.setRole(employee.getRole());

        return employeeResponse;
    }

    public static List<AddressResponse> getAddressResponseList(List<Address> addressList) {
        List<AddressResponse> addressResponseList = new ArrayList<>();

        for(int i=0 ; i<addressList.size(); i++) {
            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setAddrId(addressList.get(i).getAddrId());
            addressResponse.setFlatNo(addressList.get(i).getFlatNo());
            addressResponse.setStreet(addressList.get(i).getStreet());
            addressResponse.setPincode(addressList.get(i).getPincode());
            addressResponse.setAddressType(addressList.get(i).getAddressType());
            addressResponse.setCity(addressList.get(i).getCity());
            addressResponse.setCountry(addressList.get(i).getCountry());
            addressResponse.setState(addressList.get(i).getState());
            addressResponse.setEmpId(addressList.get(i).getEmployee().getEmpId());
            addressResponseList.add(addressResponse);
        }
        return addressResponseList;
    }

    public static List<EmployeeSkillResponse> getEmployeeSkillResponse(List<EmployeeSkill> employeeSkillList){
        List<EmployeeSkillResponse> employeeSkillResponseList = new ArrayList<>();
        for(int i=0; i<employeeSkillList.size(); i++){
            EmployeeSkillResponse employeeSkillResponse = new EmployeeSkillResponse();
            employeeSkillResponse.setEmpId(employeeSkillList.get(i).getEmployee().getEmpId());
            employeeSkillResponse.setSkill(employeeSkillList.get(i).getSkill());
            employeeSkillResponse.setLevels(employeeSkillList.get(i).getLevels());
            employeeSkillResponseList.add(employeeSkillResponse);
        }
        return employeeSkillResponseList;
    }

    public static EmployeeAccountResponse getEmployeeAccountResponse(EmployeeAccount employeeAccount){
        EmployeeAccountResponse employeeAccountResponse = new EmployeeAccountResponse();
        employeeAccountResponse.setEmpId(employeeAccount.getEmployeeAccountId().getEmployee().getEmpId());
        employeeAccountResponse.setPan(employeeAccount.getPan());
        employeeAccountResponse.setUan(employeeAccount.getUan());
        employeeAccountResponse.setPfNo(employeeAccount.getPfNo());

        return employeeAccountResponse;
    }
}
