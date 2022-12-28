package com.rafszef.wheresourmoney.controller;

import com.rafszef.wheresourmoney.model.dto.entry.CreateEntryDto;
import com.rafszef.wheresourmoney.model.dto.entry.EntryDto;
import com.rafszef.wheresourmoney.model.dto.user.UserDto;
import com.rafszef.wheresourmoney.service.entry.EntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/entry")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")

public class EntryController {

    private final EntryService entryService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public List<EntryDto> getAllEntries() {
        return entryService.getAllEntries();
    }

    @GetMapping("/findByUser")
    public List<EntryDto> findEntriesByUser(@RequestParam String username) {
        return entryService.findEntriesByUser(username);
    }

    @GetMapping("/findAllIncomes")
    public List<EntryDto> findAllIncomes() {
        return entryService.findAllIncomes();
    }

    @GetMapping("/findAllOutcomes")
    public List<EntryDto> findAllOutcomes() {
        return entryService.findAllOutcomes();
    }

    @GetMapping("/findInRannge")
    public List<EntryDto> findEntriesInRange(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
        return entryService.findEntriesWithAmountBetween(min, max);
    }

    @GetMapping("/findGreater")
    public List<EntryDto> findEntriesGreaterThan(@RequestParam BigDecimal min) {
        return entryService.findEntriesWithAmountGreaterThan(min);
    }

    @GetMapping("/findLesser")
    public List<EntryDto> findEntriesLesserThan(@RequestParam BigDecimal max) {
        return entryService.findEntriesWithAmountLessThan(max);
    }
    @PostMapping("/create")
    public EntryDto createEntry(@RequestBody CreateEntryDto createEntryDto) {
        return entryService.createEntry(createEntryDto);
    }

    @PostMapping("/update")
    public EntryDto updateEntry(@RequestBody EntryDto entryDto) {
        return entryService.changeEntry(entryDto);
    }

    @DeleteMapping("/remove")
    public void deleteEntry(@RequestBody EntryDto entryDto) {
        entryService.removeEntry(entryDto);
    }

}
