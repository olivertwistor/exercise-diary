<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Exercise extends CI_Model
{
    public function __construct()
    {
        parent::__construct();

        $this->load->database();
    }

    public function insert(string $date,
                           string $time,
                           int $type,
                           int $repetitions) : bool
    {
        if (is_null($date) || is_null($time) || is_null($type) ||
                is_null($repetitions))
        {
            return false;
        }

        // Concatenate the date and the time to a timestamp string.
        $timestamp = $date . ' ' . $time;

        $insert_data = [
            'exercise_timestamp' => $timestamp,
            'exercise_type' => $type,
            'repetitions' => $repetitions
        ];

        $success = $this->db->insert('exercise', $insert_data);
        if ($success)
        {
            log_message('info',
                'Successfully inserted exercise in the database.'
            );
        }
        else
        {
            log_message('error',
                'Failed to insert exercise in the database. ' .
                var_export($this->db->error(), true)
            );
        }

        return $success;
    }
}
