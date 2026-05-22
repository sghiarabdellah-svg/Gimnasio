package com.example.gimnasio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.gimnasio.models.Clase;
import com.example.gimnasio.models.Entrenador;
import com.example.gimnasio.repositories.ClaseRepository;
import com.example.gimnasio.repositories.EntrenadorRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final EntrenadorRepository entrenadorRepository;
    private final ClaseRepository claseRepository;

    public DataLoader(EntrenadorRepository entrenadorRepository,
                      ClaseRepository claseRepository) {

        this.entrenadorRepository = entrenadorRepository;
        this.claseRepository = claseRepository;
    }

    @Override
    public void run(String... args) {

        Entrenador e1 = new Entrenador(
                "Carlos Martin",
                "Musculacion",
                "Nivel 2"
        );

        Entrenador e2 = new Entrenador(
                "Laura Gomez",
                "Yoga",
                "Instructora certificada"
        );

        Entrenador e3 = new Entrenador(
                "Miguel Torres",
                "Crossfit",
                "Entrenador funcional"
        );

        entrenadorRepository.save(e1);
        entrenadorRepository.save(e2);
        entrenadorRepository.save(e3);

        Clase c1 = new Clase(
                "Full Body",
                "Lunes",
                "10:00",
                60,
                20,
                8,
                "Intermedio"
        );

        c1.setEntrenador(e1);

        Clase c2 = new Clase(
                "Yoga Inicial",
                "Martes",
                "18:00",
                45,
                15,
                5,
                "Basico"
        );

        c2.setEntrenador(e2);

        Clase c3 = new Clase(
                "Cross Training",
                "Miercoles",
                "19:00",
                50,
                18,
                12,
                "Avanzado"
        );

        c3.setEntrenador(e3);

        claseRepository.save(c1);
        claseRepository.save(c2);
        claseRepository.save(c3);
    }
}