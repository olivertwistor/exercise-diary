<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class Migration_Add_exercise extends CI_Migration
{
    private const exercise_table_name = 'exercise';

    public function up()
    {
        // Create the "exercise" table.
        $this->dbforge->add_field('id');
        $this->dbforge->add_field(
            "exercise_timestamp TIMESTAMP NOT NULL " .
            "DEFAULT CURRENT_TIMESTAMP COMMENT 'Timestamp for when the " .
            "exercise took place.'"
        );
        $this->dbforge->add_field(array('exercise_type' => array(
            'type' => 'int',
            'constraint' => 9,
            'default' => 0
        )));
        $this->dbforge->add_field(array('repetitions' => array(
            'type' => 'int',
            'constraint' => 9,
            'default' => 1
        )));
        $this->dbforge->add_key('exercise_type');
        if ($this->dbforge->create_table(self::exercise_table_name, true))
        {
            log_message('debug',
                'Successfully created the table "' .
                self::exercise_table_name . '".'
            );
        }
        else
        {
            log_message('error',
                'Failed to create the table "' . self::exercise_table_name .
                '".'
            );
        }
    }

    public function down()
    {
        // Drop the "exercise" table.
        if ($this->dbforge->drop_table(self::exercise_table_name))
        {
            log_message('debug',
                'Successfully dropped the table "' .
                self::exercise_table_name . '".'
            );
        }
        else
        {
            log_message('error',
                'Failed to drop the table "' . self::exercise_table_name . '".'
            );
        }
    }
}
