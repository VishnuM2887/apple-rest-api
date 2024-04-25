package com.vishnu.spring.apple.mobile;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class MobileService {

    private final MobileRepository mobileRepository;

    @Autowired
    public MobileService(MobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }

    public List<Mobile> getMobiles() {
        return mobileRepository.findAll();
    }

    public Mobile getMobile(Long mobileId) {
        boolean exists = mobileRepository.existsById(mobileId);
        if (!exists) {
            throw new IllegalStateException("mobile with id " + mobileId + " does not exist");
        }
        return mobileRepository.findById(mobileId).get();
    }

    public Mobile getMobile(String mobileSKU) {
        Optional<Mobile> mobileOptional = mobileRepository.findMobileBySKU(mobileSKU);
        if (!mobileOptional.isPresent()) {
            throw new IllegalStateException("mobile with SKU " + mobileSKU + " does not exist");
        }
        return mobileRepository.findMobileBySKU(mobileSKU).get();
    }

    public void addNewMobile(Mobile mobile) {
        mobile.setSku();
        Optional<Mobile> mobileOptional = mobileRepository.findMobileBySKU(mobile.getSku());
        if (mobileOptional.isPresent()) {
            throw new IllegalStateException("mobile exists");
        }
        mobileRepository.save(mobile);
    }

    public void deleteMobile(Long mobileId) {
        boolean exists = mobileRepository.existsById(mobileId);
        if (!exists) {
            throw new IllegalStateException("mobile with id " + mobileId + " does not exist");
        }
        mobileRepository.deleteById(mobileId);
    }

    public void deleteMobile(String mobileSKU) {
        Optional<Mobile> mobileOptional = mobileRepository.findMobileBySKU(mobileSKU);
        if (!mobileOptional.isPresent()) {
            throw new IllegalStateException("mobile with SKU " + mobileSKU + " does not exist");
        }
        mobileRepository.deleteById(mobileOptional.get().getId());
    }

    @Transactional
    public void updateMobile(Long mobileId, Mobile mobile) {
        boolean exists = mobileRepository.existsById(mobileId);
        if (!exists) {
            throw new IllegalStateException("mobile with id " + mobileId + " does not exist");
        }

        Mobile existingMobile = mobileRepository.findById(mobileId).get();

        if (mobile.getName() != null && mobile.getName().length() > 0) {
            existingMobile.setName(mobile.getName());
        }
        if (mobile.getGeneration() != null && mobile.getGeneration().length() > 0) {
            existingMobile.setGeneration(mobile.getGeneration());
        }

        existingMobile.setSuffix(mobile.getSuffix());
        
        if (mobile.getStorage() != null && mobile.getStorage() >= 32) {
            existingMobile.setStorage(mobile.getStorage());
        }
        if (mobile.getColor() != null && mobile.getColor().length() > 0) {
            existingMobile.setColor(mobile.getColor());
        }
        if (mobile.getMrp() != null && mobile.getMrp() > 0) {
            existingMobile.setMrp(mobile.getMrp());
        }

        existingMobile.setSku();
    }

    @Transactional
    public void updateMobile(String mobileSKU, Mobile mobile) {
        Optional<Mobile> mobileOptional = mobileRepository.findMobileBySKU(mobileSKU);
        if (!mobileOptional.isPresent()) {
            throw new IllegalStateException("mobile with SKU " + mobileSKU + " does not exist");
        }

        Mobile existingMobile = mobileRepository.findMobileBySKU(mobileSKU).get();

        if (mobile.getName() != null && mobile.getName().length() > 0) {
            existingMobile.setName(mobile.getName());
        }
        if (mobile.getGeneration() != null && mobile.getGeneration().length() > 0) {
            existingMobile.setGeneration(mobile.getGeneration());
        }

        existingMobile.setSuffix(mobile.getSuffix());
        
        if (mobile.getStorage() != null && mobile.getStorage() >= 32) {
            existingMobile.setStorage(mobile.getStorage());
        }
        if (mobile.getColor() != null && mobile.getColor().length() > 0) {
            existingMobile.setColor(mobile.getColor());
        }
        if (mobile.getMrp() != null && mobile.getMrp() > 0) {
            existingMobile.setMrp(mobile.getMrp());
        }

        existingMobile.setSku();
    }

}