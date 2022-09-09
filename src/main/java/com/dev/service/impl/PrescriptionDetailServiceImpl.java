/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service.impl;

import com.dev.pojo.PrescriptionDetail;
import com.dev.repository.PrescriptionDetailRepository;
import com.dev.service.PrescriptionDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thanh_Tam
 */
@Service
public class PrescriptionDetailServiceImpl implements PrescriptionDetailService {

    @Autowired
    PrescriptionDetailRepository prescriptionDetailRepository;

    @Override
    public PrescriptionDetail getPrescriptionDetailById(int prescriptionDetailID) {
        return this.prescriptionDetailRepository.getPrescriptionDetailById(prescriptionDetailID);
    }

    @Override
    public PrescriptionDetail alterPrescriptionDetail(int prescriptionDetailID, String quantity) {
        return this.prescriptionDetailRepository.alterPrescriptionDetail(prescriptionDetailID, quantity);
    }

    @Override
    public List<PrescriptionDetail> getPrescriptionDetails(int prescriptionID) {
        return this.prescriptionDetailRepository.getPrescriptionDetails(prescriptionID);
    }

    @Override
    public boolean addPrescriptionDetail(PrescriptionDetail pd) {
        return this.prescriptionDetailRepository.addPrescriptionDetail(pd);
    }

    @Override
    public boolean deletePrescriptionDetail(int id) {
        return this.prescriptionDetailRepository.deletePrescriptionDetail(id);
    }

    @Override
    public void updatePrescriptionDetail(PrescriptionDetail pd, int prescriptionDetailId) {
        this.prescriptionDetailRepository.updatePrescriptionDetail(pd, prescriptionDetailId);
    }

        @Override
        public List<PrescriptionDetail> countMedicineByMonth(int month) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public List<PrescriptionDetail> countMedicineByQuarter(int quarter) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public List<PrescriptionDetail> countMedicineByYear(int year) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

}
