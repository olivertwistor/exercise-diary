<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * Base model class that inherits from CodeIgniter's base model class, extending
 * it in three ways:
 *
 * <ul>
 * <li>Providing method skeletons for CRUD operations (create, read, update and
 * delete).
 * <li>Providing a method to set all properties matching an associative array.
 * Useful for dumping the $_POST array into the object (preferrably after proper
 * sanitizing).
 * <li>The magic methods `__get` and `__set` work with all private properties,
 * and custom getters and setters will be called automatically, if they exist.
 * </ul>
 *
 * @link http://blog.newmythmedia.com/blog/show/2016-10-27_Better_Entities_In_CodeIgniter_4 Inspiration for this class
 *
 * @author Johan Nilsson
 *
 * @since 0.1.0
 */
class MY_Model extends CI_Model
{
    public function __construct()
    {
        parent::__construct();

        $this->load->database();
    }

    public function create(string $db_table) : int
    {
        if (is_null($db_table))
        {
            throw new InvalidArgumentException('$db_table must not be null.');
        }

        $success = $this->db->insert($db_table, $this);
        if ($success)
        {
            $row_id = $this->db->insert_id();
            return $row_id;
        }

        return 0;
    }

    public function read(int $row_id) : void
    {
        throw new BadMethodCallException(
            'Not implemented. You probably wanted to call this from a subclass 
            of MY_Model.'
        );
    }

    /**
     * Gets all records from the database.
     *
     * @return array All records from the database in the form of stdObjects.
     *
     * @since 0.1.0
     */
    public function read_all(string $db_table): array
    {
        if (is_null($db_table))
        {
            throw new InvalidArgumentException('$db_table must not be null.');
        }

        /** @var CI_DB_result $query */
        $query = $this->db->get($db_table);

        $all_records = $query->result();

        return $all_records;
    }

    public function update(int $row_id) : bool
    {
        throw new BadMethodCallException(
            'Not implemented. You probably wanted to call this from a subclass 
            of MY_Model.'
        );
    }

    public function delete(int $row_id) : bool
    {
        throw new BadMethodCallException(
            'Not implemented. You probably wanted to call this from a subclass 
            of MY_Model.'
        );
    }

    /**
     * Takes an associative array with data (for example from the $_POST array)
     * and for each of the keys that matches a property in this class, sets its
     * value. If there are defined setter methods, they will be called instead
     * of just setting the property directly.
     *
     * Think of this method as a substitute for individually setting every
     * property in the class.
     *
     * @param array $data associative array with properties and their values
     *
     * @since 0.1.0
     */
    public function fill(array $data) : void
    {
        foreach ($data as $key => $value)
        {
            $method_name = 'fill_' . $key;
            if (method_exists($this, $method_name))
            {
                $this->$method_name($value);
            }
            else if (property_exists($this, $key))
            {
                $this->$key = $value;
            }
        }
    }

    /**
     * Returns the value of a class property.
     *
     * If there is a getter method for the class property in question, that will
     * be called automatically.
     *
     * @param string $key name of the class property which value to return
     *
     * @return mixed|null The value of the class property; null if the parameter
     *                    doesn't exist or is null.
     *
     * @since 0.1.0
     */
    public function __get($key)
    {
        if (is_null($key))
        {
            log_message('error', 'The property name must not be null.');
            return null;
        }

        $method_name = 'get_' . $key;
        if (method_exists($this, $method_name))
        {
            return $this->$method_name($key);
        }

        if (isset($this->$key))
        {
            return $this->$key;
        }

        return parent::__get($key);
    }

    /**
     * Sets the value of a class property if it exists and is not null.
     *
     * If there is a setter method for the class property in question, that will
     * be called automatically.
     *
     * @param string $key name of the class property which value to set
     * @param mixed $value the value of the class property
     *
     * @since 0.1.0
     */
    public function __set(string $key, $value) : void
    {
        if (is_null($key))
        {
            log_message('error', 'The property name must not be null.');
            return;
        }

        $method_name = 'set_' . $key;
        if (method_exists($this, $method_name))
        {
            $this->$method_name($value);
        }
        else if (isset($this->$key))
        {
            $this->$key = $value;
        }
    }
}
