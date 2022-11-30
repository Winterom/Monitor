ALTER TABLE controllers
    ADD CONSTRAINT fk_controllers_segments
        FOREIGN KEY (segment_id)
            REFERENCES segments (id);

ALTER TABLE controllers
    ADD CONSTRAINT fk_controllers_plc_profiles
        FOREIGN KEY (profile_id)
            REFERENCES plc_profiles (id);

ALTER TABLE commands
    ADD CONSTRAINT fk_commands_plc_profiles
        FOREIGN KEY (profile_id)
            REFERENCES plc_profiles (id);

ALTER TABLE plc_event_journal
    ADD CONSTRAINT fk_journal_controllers
        FOREIGN KEY (plc_id)
            REFERENCES controllers(id);
